<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <link rel="icon" href="img/favicon.png" type="image/png" />
  <title>AGAM</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/css/bootstrap.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/vendors/linericon/style.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/css/font-awesome.min.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/css/themify-icons.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/css/flaticon.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/vendors/owl-carousel/owl.carousel.min.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/vendors/lightbox/simpleLightbox.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/vendors/nice-select/css/nice-select.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/vendors/animate-css/animate.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/vendors/jquery-ui/jquery-ui.css" />
  <!-- main css -->
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/css/style.css" />
  <link rel="stylesheet" href="http://localhost:1000/Aim/resources/css/responsive.css" />
</head>

<body>
  <!--================Header Menu Area =================-->
  <header class="header_area">
    <div class="top_menu">
      <div class="container">
        <div class="row">
          <div class="col-lg-7">
            <div class="float-left">
              <p>Phone: +91 9460783175</p>
              <p>email: jainshibbu2001@gmail.com</p>
            </div>
          </div>
          <div class="col-lg-5">
            <div class="float-right">
              <ul class="right_side">
                <li>
                  <a href="#">
                    Contact Us
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="main_menu">
      <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light w-100">
          <!-- Brand and toggle get grouped for better mobile display -->
          <a class="navbar-brand logo_h" href="/Aim/">
            <img src="http://localhost:1000/Aim/resources/img/logo1.png" alt="" height=48px width=137px/>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse offset w-100" id="navbarSupportedContent">
            <div class="row w-100 mr-0">
              <div class="col-lg-7 pr-0">
                <ul class="nav navbar-nav center_nav pull-right">
                  <li class="nav-item">
                    <a class="nav-link" href="/Aim/merge/">MERGE PDF</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/Aim/split/">SPLIT PDF</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/Aim/compress/">COMPRESS PDF</a>
                  </li>
                  <li class="nav-item submenu dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                      aria-expanded="false">ALL TOOLS</a>
                    <ul class="dropdown-menu">
                      <li class="nav-item">
                        <a class="nav-link" href="/Aim/unlock/">UNLOCK PDF</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="/Aim/merge/">MERGE PDF</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="/Aim/compress/">COMPRESS PDF</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="/Aim/pdftojpg/">PDF TO JPG</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div>

              <div class="col-lg-5 pr-0">
                <ul class="nav navbar-nav navbar-right right_nav pull-right">
                    
                  <li class="nav-item">
                    <a href="#" class="icons">
						<%= request.getParameter("username") %>
					</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </nav>
      </div>
    </div>
  </header>
  <section class="home_banner_area mb-40">
    <div class="banner_inner d-flex align-items-center">
      <div class="container">
        <div class="banner_content row">
          <div class="col-lg-12">
            <p class="sub text-uppercase">Every tool you need to work with PDFs in one place</p>
            <h3><span>Online</span><br />PDF<span>Editor</span></h3>
            <h4>Every tool you need to use PDFs, at your fingertips. All are 100% FREE and easy to use! Merge, split, compress, convert, rotate, unlock and watermark PDFs with just a few clicks.</h4>
            <a class="main_btn mt-40" href="#">LEARN MORE</a>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section class="feature_product_area section_gap_bottom_custom">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-12">
          <div class="main_title">
            <h2><span>OUR FACILITIES</span></h2>
         </div>
        </div>
      </div>

      <div class="row">
        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img class="img-fluid w-100" src="http://localhost:1000/Aim/resources/img/product/feature-product/f-p-10.png" alt="" height=50 px/>
              
            </div>
            <div class="product-btm">
              <a href="/Aim/merge" class="d-block">
                <h4>MERGE PDF</h4>
              </a>
              <div class="mt-3">
                <span class="mr-4">Combine PDF in the order you want with the easiest merger available.</span>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img class="img-fluid w-100" src="http://localhost:1000/Aim/resources/img/product/feature-product/f-p-11.png" alt="" />
            </div>
            <div class="product-btm">
              <a href="/Aim/compress" class="d-block">
                <h4>COMPRESS PDF</h4>
              </a>
              <div class="mt-3">
                <span class="mr-4">Reduce File size while optimising for maximal PDF quality.It will also make easy to share the file.</span>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img class="img-fluid w-100" src="http://localhost:1000/Aim/resources/img/product/feature-product/f-p-12.png" alt="" />
            </div>
            <div class="product-btm">
              <a href="/Aim/split" class="d-block">
                <h4>SPLIT PDF</h4>
              </a>
              <div class="mt-3">
                <span class="mr-4">Want to Split PDF in to different single page PDF then, this option is only for you.</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
    <section class="feature_product_area section_gap_bottom_custom">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-12">
          <div class="main_title">
            
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img class="img-fluid w-100" src="http://localhost:1000/Aim/resources/img/product/feature-product/f-p-13.png" alt="" />

            </div>
            <div class="product-btm">
              <a href="/Aim/remove" class="d-block">
                <h4>REMOVE PAGE</h4>
              </a>
              <div class="mt-3">
                <span class="mr-4">Want to remove a particular page from a PDF. Then, this option will be useful for you only.</span>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img class="img-fluid w-100" src="http://localhost:1000/Aim/resources/img/product/feature-product/f-p-15.png" alt="" />
            </div>
            <div class="product-btm">
              <a href="/Aim/unlock" class="d-block">
                <h4>
                	UNLOCK PDF
                </h4>
              </a>
              <div class="mt-3">
                <span class="mr-4">Want to unlock your PDF.Then,this option is for you.</span>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img class="img-fluid w-100" src="http://localhost:1000/Aim/resources/img/product/feature-product/f-p-14.png" alt="" />
            </div>
            <div class="product-btm">
              <a href="/Aim/pdftojpg" class="d-block">
                <h4>PDF TO IMAGE</h4>
              </a>
              <div class="mt-3">
                <span class="mr-4">Want to convert a PDF file into a image file. Then, this option will provide you the best facility.</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section class="">
    <div class="container">
      <div class="row justify-content-center">
        <div class="">
          <div class="offer_content">
            <h3 class="text-uppercase mb-40">WANT MORE? GET MORE</h3>
            <h3 class="text-uppercase mb-40">Push our limits by Signing up for free</h3>
            <h2 class="text-uppercase">REGISTER NOW</h2>
            <a href="/Aim/register" class="main_btn mb-20 mt-5">REGISTER</a>
          </div>
        </div>
      </div>
    </div>
</section>
  <!--================ End Offer Area =================-->

  <!--================ start footer Area  =================-->
  <footer class="footer-area section_gap">
    <div class="container">
      <div class="row">
        <div class="col-lg-2 col-md-6 single-footer-widget">
          <h4>Online Pdf Editor</h4>
          <ul>
            <li><a href="/Aim/">Home</a></li>
            <li><a href="#">Features</a></li>
            <li><a href="#">Pricing</a></li>
            <li><a href="#">Tools</a></li>
            <li><a href="#">FAQs</a></li>
          </ul>
        </div>
        <div class="col-lg-4 col-md-6 single-footer-widget">
          <h4>Newsletter</h4>
          <p>You can trust us. we only send promo offers,</p>
          <div class="form-wrap" id="mc_embed_signup">
            <form target="_blank" action="#"
              method="get" class="form-inline">
              <input class="form-control" name="EMAIL" placeholder="Your Email Address" onfocus="this.placeholder = ''"
                onblur="this.placeholder = 'Your Email Address '" required="" type="email">
              <button class="click-btn btn btn-default">Subscribe</button>
              <div style="position: absolute; left: -5000px;">
                <input name="" tabindex="-1" value="" type="text">
              </div>

              <div class="info"></div>
            </form>
          </div>
        </div>
      </div>
      <div class="footer-bottom row align-items-center">
        <p class="footer-text m-0 col-lg-8 col-md-12"></p>
        <div class="col-lg-4 col-md-12 footer-social">
          <a href="#"><i class="fa fa-facebook"></i></a>
          <a href="#"><i class="fa fa-twitter"></i></a>
          <a href="#"><i class="fa fa-dribbble"></i></a>
          <a href="#"><i class="fa fa-behance"></i></a>
        </div>
      </div>
  </footer>
  <!--================ End footer Area  =================-->
</body>

</html>