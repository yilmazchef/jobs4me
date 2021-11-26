# Recruitment System

## Functional Requirements
Do you want to learn how to design a database system and map a business process to a data model? Then this post is for you.

In this article, you’ll see how to design a simple database schema for a recruitment company. After reading this tutorial, you will be able to understand how database schemas are designed for real-world applications.

### The Recruitment System Business Process

Before designing any database or data model, it is imperative to understand the basic business process for that system. The database schema we’ll create is for an imaginary recruitment company or team. Let’s first see the steps involved in hiring new employees:

1.  Companies contact recruitment agencies to hire on their behalf. In some cases, companies recruit employees directly.
2.  The person responsible for recruitment starts the recruiting process. This process can have multiple steps, such as the initial screening, a written test, the first interview, the follow-up interview, the actual hiring decision, etc.
3.  Once the recruiters have agreed on a particular process – and this can change depending on the client, the company, or the job in question – the vacancy is advertised on various platforms.
4.  Applicants start applying for the job.
5.  The applicants are shortlisted and invited to a test or initial interview.
6.  The applicants appear for the test/interview.
7.  The tests are graded by the recruiters. In some cases, tests are forwarded to specialists for grading.
8.  Applicants’ interviews are scored by one or more recruiters.
9.  Applicants are evaluated on the basis of tests and interviews.
10.  The hiring decision is made.

### A Recruitment System Database Schema

In view of the aforementioned process, our database schema is divided into five subject areas:

-   `**Process**`
-   `**Jobs**`
-   `**Application, Applicant, and Documents**`
-   `**Test and Interviews**`
-   `**Recruiters and Application Evaluation**`

### A Simple Recruiting Use Case

Let’s see how our database could help the recruiting process.

Suppose a company has assigned you to hire an IT Manager with programming experience. Our database can help us hire such a person by executing the following steps:

1.  The first step is to start a new hiring process. To do so, data is entered into the `**process**` and `**steps**` tables. A recruiter can add as many steps as they need.
2.  During the above task, the recruiter might create a new job and enter the details in the `**job**`, `**job_category**`, `**job_position**`, and `**organization**` tables. Finally, a job advertisement will be placed in one of the platforms stored in the `**job_platform**` table.
3.  Next, applicants will create a profile by submitting their data to the `**applicant**` table. Then they’ll launch a new application by entering more data into the `**application**` table.
4.  Applicants may also attach documents to their applications. This data will be stored in the `**document**` and `**application_document**` tables.
5.  If a user wants to apply to more than one job, they will repeat steps 3 and 4.
6.  Once the application is submitted, the status of the application will be set to “submitted” (or another status name chosen by the recruiter).
7.  The recruiter will evaluate the application and enter their feedback in the `**application_evaluation**` table. At this stage, the hired column will contain no information.
8.  Once an adequate number of applications are received, the recruiter will execute the next step shown in the `**process_step**` table.
9.  If the next step is to administer some kind of test, the recruiter will create a test by adding data into the `**test**` table.
10.  The test(s) created in step 9 will be assigned to a particular application. The information that assigns each test to each application will be stored in the `**application_test**` table. Note that, during each stage, the status of the application will keep changing. This will be recorded in the `**application_status_change**` table.
11.  Once the applicant completes the test, the grades for each application test will be marked by the recruiter and entered into the `**answer**` table.
12.  Once the test is taken, the next step from the `**process_step**` table will be executed. Let’s say the next step is the interview.
13.  The interview data will be entered in the `**interview**` table. The recruiter will enter their comments and say whether the person passed the interview or not. This will be stored in the `**interview_note**` table.
14.  If the `**process**` table contains further interview and test steps, they will be executed until the last step is reached.
15.  The last step in the `**process_step**` table is normally the hiring decision. If the applicant passes their tests and interviews and the company decides to hire them, data is entered in the hire column of the `**application_evaluation**` table and the person is hired.


## Technical Requirements

This project can be used as a starting point to create your own Vaadin application.
It has the necessary dependencies and files to help you get started.

The best way to use it is via [vaadin.com/start](https://vaadin.com/start) - you can get only the necessary parts and choose the package naming you want to use.
There is also a [getting started tutorial](https://vaadin.com/tutorials/getting-started-with-flow) based on this project.

To access it directly from github, clone the repository and import the project to the IDE of your choice as a Maven project. You need to have Java 8 or 11 installed.

Run using `mvn jetty:run` and open [http://localhost:8080](http://localhost:8080) in the browser.

If you want to run your app locally in the production mode, run `mvn jetty:run -Pproduction`.

### Running Integration Tests

Integration tests are implemented using [Vaadin TestBench](https://vaadin.com/testbench). The tests take a few minutes to run and are therefore included in a separate Maven profile. We recommend running tests with a production build to minimize the chance of development time toolchains affecting test stability. To run the tests using Google Chrome, execute

`mvn verify -Pit,production`

and make sure you have a valid TestBench license installed.

Profile `it` adds the following parameters to run integration tests:
```sh
-Dwebdriver.chrome.driver=path_to_driver
-Dcom.vaadin.testbench.Parameters.runLocally=chrome
```

For a full Vaadin application example, there are more choices available also from [vaadin.com/start](https://vaadin.com/start) page.

