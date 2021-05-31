<!-- PROJECT SHIELDS -->
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/basselini/spring-data-neo4j-contact-tracking">
    <img src="images/logo1.png" alt="Logo" width="auto" height="80">
  </a>
  </br>
  <a href="https://github.com/basselini/spring-data-neo4j-contact-tracking">
    <img src="images/logo2.png" alt="Logo" width="auto" height="80">
  </a>

  <h3 align="center">Spring Data Neo4j - Contact Tracking (very simple example)</h3>

</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#run-the-applicaiton">Run the applicaiton</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![product-screenshot]

There are not many simple Spring Data Neo4j projects that map all the basic functionality. For this reason, I decided to provide this simple template to anyone who is taking their first steps with this framework.

Here's a quick overview:
* Save objects (Person, Location) to the Neo4j repository
* Create relationships between the objects (Person, Location)
* View these relationships in the Neo4j interface
* Create queries to get specific information

Of course, this project is far from being used for real scenarios. It's just meant to give you an easy introduction to Spring Data Neo4j so you can customize it for your scenario.

### Built With

This section should list any major frameworks that you built your project using. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.
* [Spring Data Neo4j](https://spring.io/projects/spring-data-neo4j)
* [Neo4j](https://neo4j.com/)

<!-- GETTING STARTED -->
## Getting Started

To run the project locally, you should follow these steps:

### Prerequisites

To start the project locally, it is necessary to install Neo4j, create a database and connect to it.

* Go to the Neo4j website and download the latest version
* Install Neo4j on your computer and launch the application
* Create a new project and add a new database to it
* **Note:** When creating a new database, you must set a password for it. This must be the same as the one in application.properties
* Start the database

### Run the applicaiton

1. Clone the repo
   ```sh
   git clone https://github.com/basselini/spring-data-neo4j-contact-tracking
   ```
2. Run the application
   ```sh
   $ gradle build
   ```
   ```sh
   $ gradle run
   ```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- CONTACT -->
## Contact

Bassel Nasser - bassel.nasser@haw-hamburg.de

Project Link: [https://github.com/basselini/spring-data-neo4j-contact-tracking](https://github.com/basselini/spring-data-neo4j-contact-tracking)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[forks-shield]: https://img.shields.io/github/forks/basselini/spring-data-neo4j-contact-tracking.svg?style=for-the-badge
[forks-url]: https://github.com/basselini/spring-data-neo4j-contact-tracking/network/members
[stars-shield]: https://img.shields.io/github/stars/basselini/spring-data-neo4j-contact-tracking.svg?style=for-the-badge
[stars-url]: https://github.com/basselini/spring-data-neo4j-contact-tracking/stargazers
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/bassel-nasser-9a8687185/
[product-screenshot]: images/neo4j.png
