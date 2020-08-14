package com.aim.contoller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.aim.model.FileUpload;
import com.aim.model.LoginUser;
import com.aim.model.RegisterUser;
import com.aim.service.LoginService;
import com.aim.service.RegisterService;

@Controller
public class HomeController {
@Autowired
RegisterService registerService;
@Resource(name="loginService")
LoginService loginService;

	@RequestMapping(value="/")
	public String Home()
	{
		System.out.println("Contoller called");
		return "Home";
	}
	
	@RequestMapping(value="/register")
	public String register()
	{
		return "register";
	}
	
	@RequestMapping(value="/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value="/wantToRegister")
	public String WantToRegister(RegisterUser user) throws SQLException
	{
		String s=registerService.insertInfo(user);
		return s;
	}
	
	@RequestMapping(value="/wantToLogin")
	public String WantToLogin(LoginUser user) throws SQLException, IOException
	{
		System.out.println("Login controller");
		String s=loginService.insertLoginInfo(user);
		return s;
	}
	
	@RequestMapping(value="/merge")
	public String MergePdf() {
		return "Merge";
	}
	
	@RequestMapping(value="/split")
	public String SplitPdf() {
		return "Split";
	}
	
	@RequestMapping(value="/compress")
	public String 	CompressPdf() {
		return "Compress";
	}
	
	@RequestMapping(value="/remove")
	public String 	RemovePdf() {
		return "Remove";
	}
	
	@RequestMapping(value="/unlock")
	public String 	ProtectPdf() {
		return "Unlock";
	}
	
	@RequestMapping(value="/pdftojpg")
	public String 	PdfToJpg() {
		return "PdfToJpg";
	}
	
	@RequestMapping(value="/mergePdf", method=RequestMethod.POST)
	public String merge(HttpServletRequest req,@ModelAttribute FileUpload user) throws SQLException, IOException
	{
		ArrayList<String> filePath=uploadFileOnServerMerge(user);
		merger(filePath,req);
		System.out.println(" test controller called ");
		return "Download";
	}
	
	private void merger(ArrayList<String> filePath, HttpServletRequest req) throws IOException {
		// TODO Auto-generated method stub
		PDFMergerUtility pdf=new PDFMergerUtility();
		pdf.setDestinationFileName("E:\\download.pdf");
		
		for(String s: filePath)
		{
			File f=new File(s);
			pdf.addSource(f);
		}
		req.setAttribute("file", "E:\\download.pdf");
		
		
		pdf.mergeDocuments(null);
		System.out.println("pdf merged");
	}

	private ArrayList<String> uploadFileOnServerMerge(FileUpload user) {
		// TODO Auto-generated method stub
		String rootdirectory="E:/files/merge";
		File directory=new File(rootdirectory);
		if(!directory.exists())
		{
			directory.mkdirs();
		}
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list = new ArrayList<String>();
		for(MultipartFile filedata:f){
			String filename=filedata.getOriginalFilename();
			if(filename != null && filename.length() > 0)
			{
				try {
				filepath=directory.getCanonicalPath()+File.separator+filename;
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
				bos.write(filedata.getBytes());
				bos.close();
				list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	@RequestMapping(value="/download",method=RequestMethod.POST)
	public String download(HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println("Download is here");
		String mimeType=null;
		String file=req.getParameter("filepath");
		System.out.println("Download is here2");
		File f = new File(file);
		mimeType = getMimeType(f.getCanonicalPath());
		res.setContentType(mimeType);
		res.setHeader("Content-Disposition", "attachement;filename=\""+f.getName()+"\"");
		res.setContentLength((int)f.length());
		InputStream is=new FileInputStream(f);
		ServletOutputStream out= res.getOutputStream();
		org.apache.commons.io.IOUtils.copy(is, out);
		out.flush();
		out.close();
		is.close();
		return "ThankYou";
	}
	private String getMimeType(String canonicalPath) {
		// TODO Auto-generated method stub
		canonicalPath=canonicalPath.toLowerCase();
		if(canonicalPath.endsWith(".jpg") || canonicalPath.endsWith(".jpeg") || canonicalPath.endsWith(".jpe"))
			return "image/jpeg";
		else if(canonicalPath.endsWith(".pdf"))
			return "application/pdf";
		else
			return "application/pdf";
	}
	@RequestMapping(value="/compressPdf", method=RequestMethod.POST)
	public String compress(HttpServletResponse res, @ModelAttribute FileUpload user) throws IOException {
		
		System.out.println("Agam is here");
		ArrayList<String> filePath=uploadFileOnServerCompress(user);
		compressor(filePath, res);
		return "Download";
	}

	private ArrayList<String> uploadFileOnServerCompress(FileUpload user) {
		// TODO Auto-generated method stub
		String rootdirectory="E:/files/compress";
		File directory=new File(rootdirectory);
		if(!directory.exists())
		{
			directory.mkdirs();
		}
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list = new ArrayList<String>();
		for(MultipartFile filedata:f){
			String filename=filedata.getOriginalFilename();
			if(filename != null && filename.length() > 0)
			{
				try {
				filepath=directory.getCanonicalPath()+File.separator+filename;
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
				bos.write(filedata.getBytes());
				bos.close();
				list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	private void compressor(ArrayList<String> filePath, HttpServletResponse res) throws IOException {
		// TODO Auto-generated method stub
		String FileName="E:/download.zip";
		FileOutputStream fos=new FileOutputStream(FileName);
		ZipOutputStream zos=new ZipOutputStream(fos);
		for(String s:filePath)
		{
			zos.putNextEntry(new ZipEntry(new File(s).getName()));
			byte[] bytes=Files.readAllBytes(Paths.get(s));
			zos.write(bytes);
			zos.closeEntry();
		}
		zos.close();
		File f=new File(FileName);
		res.setContentType("application/zip");
		res.setHeader("Content-Disposition", "attachement;filename=\""+f.getName()+"\"");
		res.setContentLength((int)f.length());
		InputStream is=new FileInputStream(f);
		ServletOutputStream out= res.getOutputStream();
		org.apache.commons.io.IOUtils.copy(is, out);
	}
	
	@RequestMapping(value="/splitPdf", method=RequestMethod.POST)
	public String split(HttpServletResponse res, @ModelAttribute FileUpload user) throws IOException{
		
		ArrayList<String> filepath=uploadFileOnServerSplit(user);
		String s=splitter(filepath,res);
		System.out.println("Agam is here");
		return s;
	}

	private String splitter(ArrayList<String> filepath, HttpServletResponse res) throws InvalidPasswordException, IOException {
		// TODO Auto-generated method stub
		File file=new File(filepath.get(0));
		PDDocument pd=PDDocument.load(file);
		Splitter sp=new Splitter();
		
		List<PDDocument> pd1=sp.split(pd);
		Iterator<PDDocument> it=pd1.listIterator();
		int i=1;
		List<String> filepaths=new ArrayList<String>();
		
		while(it.hasNext())
		{
			String x="E:/files/split/split"+i+".pdf";
			PDDocument pd2=it.next();
			pd2.save(x);
			i++;
			filepaths.add(x);
		}
		pd.close();
		String s=zipFiles(filepaths,res);
		return s;
	}

	private String zipFiles(List<String> filepaths, HttpServletResponse res) throws IOException {
		// TODO Auto-generated method stub
		String zipFileName="E:/download.zip";
		FileOutputStream fos=new FileOutputStream(zipFileName);
		ZipOutputStream zos=new ZipOutputStream(fos);
		for(String s:filepaths)
		{
			zos.putNextEntry(new ZipEntry(new File(s).getName()));
			byte[] bytes=Files.readAllBytes(Paths.get(s));
			zos.write(bytes);
			zos.closeEntry();
		}
		zos.close();
		File f = new File(zipFileName);
		res.setContentType("application/zip");
		res.setHeader("Content-Disposition", "attachement;filename=\""+f.getName()+"\"");
		res.setContentLength((int)f.length());
		FileInputStream is=new FileInputStream(f);
		ServletOutputStream out= res.getOutputStream();
		org.apache.commons.io.IOUtils.copy(is, out);
		is.close();
		out.flush();
		out.close();
		return "Download";
	}

	private ArrayList<String> uploadFileOnServerSplit(FileUpload user) {
		// TODO Auto-generated method stub
		String rootdirectory="E:/files/split";
		File directory=new File(rootdirectory);
		if(!directory.exists())
		{
			directory.mkdirs();
		}
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list = new ArrayList<String>();
		for(MultipartFile filedata:f){
			String filename=filedata.getOriginalFilename();
			if(filename != null && filename.length() > 0)
			{
				try {
				filepath=directory.getCanonicalPath()+File.separator+filename;
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
				bos.write(filedata.getBytes());
				bos.close();
				list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String remove(HttpServletRequest req, @ModelAttribute FileUpload user) throws IOException{
		
		ArrayList<String> filepath=uploadFileOnServerRemove(user);
		String s=remover(filepath,req,user);
		System.out.println("Agam is here");
		return s;
	}

	private String remover(ArrayList<String> filepath, HttpServletRequest req,@ModelAttribute FileUpload user) throws InvalidPasswordException, IOException {
		// TODO Auto-generated method stub
		File file=new File(filepath.get(0));
		PDDocument pd=PDDocument.load(file);
		
		int totalpage=pd.getNumberOfPages();
		System.out.println(totalpage);
		pd.removePage(user.getPages()+1);
		pd.save("E:\\download.pdf");
		req.setAttribute("file", "E:\\download.pdf");
		return "Download";
	}

	private ArrayList<String> uploadFileOnServerRemove(FileUpload user) {
		// TODO Auto-generated method stub
		String rootdirectory="E:/files/remove";
		File directory=new File(rootdirectory);
		if(!directory.exists())
		{
			directory.mkdirs();
		}
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list = new ArrayList<String>();
		for(MultipartFile filedata:f){
			String filename=filedata.getOriginalFilename();
			if(filename != null && filename.length() > 0)
			{
				try {
				filepath=directory.getCanonicalPath()+File.separator+filename;
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
				bos.write(filedata.getBytes());
				bos.close();
				list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	@RequestMapping(value="/PdfToImage", method=RequestMethod.POST)
	public String PdfToImage(HttpServletRequest req, @ModelAttribute FileUpload user,HttpServletResponse res) throws IOException{
		
		ArrayList<String> filepath=uploadFileOnServerPdfToImage(user);
		String s=converter(filepath,req,user,res);
		System.out.println("Agam is here");
		return s;
	}

	private String converter(ArrayList<String> filepath, HttpServletRequest req, FileUpload user, HttpServletResponse res) throws InvalidPasswordException, IOException {
		// TODO Auto-generated method stub
		File file=new File(filepath.get(0));
		PDDocument pd=PDDocument.load(file);
		
		PDFRenderer re=new PDFRenderer(pd);
		
		int totalpage=pd.getNumberOfPages();
		List<String> filepaths=new ArrayList<String>();
		int i=0;
		while(i<totalpage)
		{
			BufferedImage img = re.renderImage(i);
			String x="E:/files/split"+i+".jpg";
			File f=new File("E:/files/split"+i+".jpg");
			ImageIO.write(img,"JPEG",f);
			i++;
			filepaths.add(x);
		}
		
		pd.close();
		zipFiles(filepaths,res);
		return "Download";
	}

	private ArrayList<String> uploadFileOnServerPdfToImage(FileUpload user) {
		
		String rootdirectory="E:/files/PdfToImage";
		File directory=new File(rootdirectory);
		if(!directory.exists())
		{
			directory.mkdirs();
		}
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list = new ArrayList<String>();
		for(MultipartFile filedata:f){
			String filename=filedata.getOriginalFilename();
			if(filename != null && filename.length() > 0)
			{
				try {
				filepath=directory.getCanonicalPath()+File.separator+filename;
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
				bos.write(filedata.getBytes());
				bos.close();
				list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	@RequestMapping(value="/unlockPdf", method=RequestMethod.POST)
	public String unlock(HttpServletRequest req,@ModelAttribute FileUpload user) throws SQLException, IOException
	{
		ArrayList<String> filePath=uploadFileOnServerUnlock(user);
		unlocker(filePath,req,user);
		System.out.println(" test controller called ");
		return "Download";
	}

	private void unlocker(ArrayList<String> filePath, HttpServletRequest req,@ModelAttribute FileUpload user) throws InvalidPasswordException, IOException {
		// TODO Auto-generated method stub
		File file=new File(filePath.get(0));
		PDDocument pd=PDDocument.load(file,user.getPassword());
		pd.setAllSecurityToBeRemoved(true);
		pd.save("E:\\download.pdf");
		req.setAttribute("file", "E:\\download.pdf");
		pd.close();
	}

	private ArrayList<String> uploadFileOnServerUnlock(FileUpload user) {
		// TODO Auto-generated method stub
		String rootdirectory="E:/files/Unlock";
		File directory=new File(rootdirectory);
		if(!directory.exists())
		{
			directory.mkdirs();
		}
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list = new ArrayList<String>();
		for(MultipartFile filedata:f){
			String filename=filedata.getOriginalFilename();
			if(filename != null && filename.length() > 0)
			{
				try {
				filepath=directory.getCanonicalPath()+File.separator+filename;
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
				bos.write(filedata.getBytes());
				bos.close();
				list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
