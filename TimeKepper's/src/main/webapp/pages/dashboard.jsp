<%@page import="model.ProductModel"%>
<%@page import="java.util.ArrayList"%>
<span style="font-family: verdana, geneva, sans-serif;">
  <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>Dashboard | By Code Info</title>
      <link rel="stylesheet" href="admin2.css" />
      <!-- Font Awesome Cdn Link -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/dashboard.css" />
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
      <div class="container">
        <nav>
          <ul>
            <li><a href="#" class="logo">
              <img src="/logo.jpg" alt="">
              <span class="nav-item">DashBoard</span>
            </a></li>
            <li><a href="#">
              <i class="fas fa-home"></i>
              <span class="nav-item">Home</span>
            </a></li>
            <li><a href="">
              <i class="fas fa-user"></i>
              <span class="nav-item">Profile</span>
            </a></li>
            <li><a href="">
              <i class="fas fa-wallet"></i>
              <span class="nav-item">Wallet</span>
            </a></li>
            <li><a href="">
              <i class="fas fa-chart-bar"></i>
              <span class="nav-item">Analytics</span>
            </a></li>
            <li><a href="">
              <i class="fas fa-tasks"></i>
              <span class="nav-item">Tasks</span>
            </a></li>
            <li><a href="">
              <i class="fas fa-cog"></i>
              <span class="nav-item">Settings</span>
            </a></li>
            <li><a href="">
              <i class="fas fa-question-circle"></i>
              <span class="nav-item">Help</span>
            </a></li>
            <li><a href="" class="logout">
              <i class="fas fa-sign-out-alt"></i>
              <span class="nav-item">Log out</span>
            </a></li>
          </ul>
        </nav>

        <div class="other_section">
    
        <section class="main">
          <div class="main-top">
            <h1>Skills</h1>
            <i class="fas fa-user-cog"></i>
          </div>
          <div class="main-skills">
            <div class="card">
              <i class="fas fa-laptop-code"></i>
              <h3>Web developemt</h3>
              <p>Join Over 1 million Students.</p>
              <button>Get Started</button>
            </div>
            <div class="card">
              <i class="fab fa-wordpress"></i>
              <h3>WordPress</h3>
              <p>Join Over 3 million Students.</p>
              <button>Get Started</button>
            </div>
            <div class="card">
              <i class="fas fa-palette"></i>
              <h3>graphic design</h3>
              <p>Join Over 2 million Students.</p>
              <button>Get Started</button>
            </div>
          </div>
 
        </section>

        <section id="content">
            <!-- NAVBAR -->
            
            <main>

                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Product Details</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>Model No</th>
                                    <th>Color</th>
                                    <th>Qunatity</th>
                                    <th>Brand Name</th>
                                    <th>Watch Type</th>
                                    <th>Case Material</th>
                                    <th>Weight</th>
                                    <th>price</th>
                                    <th>Men</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <img src="../sources/homepageimages/reviewer.png">
                                        <p>avi123</p>
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="img/people.png">
                                        <p>John Doe</p>
                                    </td>
                                    <td>01-10-2021</td>
                                    <td><span class="status pending">Pending</span></td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="img/people.png">
                                        <p>John Doe</p>
                                    </td>
                                    <td>01-10-2021</td>
                                    <td><span class="status process">Process</span></td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="img/people.png">
                                        <p>John Doe</p>
                                    </td>
                                    <td>01-10-2021</td>
                                    <td><span class="status pending">Pending</span></td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="img/people.png">
                                        <p>John Doe</p>
                                    </td>
                                    <td>01-10-2021</td>
                                    <td><span class="status completed">Completed</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                </div>
            </main>
            <!-- MAIN -->
        </section>
    </div>
    </div>

        
      
    </body>
    </html></span>