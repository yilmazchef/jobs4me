create table if not exists recruiter
(
    id         int unique not null auto_increment,
    first_name nvarchar(100),
    last_name  nvarchar(100),
    email      nvarchar(255),

    constraint pk_recruiter primary key (id)

) charset = UTF8MB4;


create table if not exists process
(
    id           int unique     not null auto_increment,
    code         nvarchar(10)   not null,
    description  nvarchar(1000) null,
    recruiter_id int            not null,

    constraint pk_process primary key (id),

    constraint fk_recruiter_process foreign key (recruiter_id) references recruiter (id)

) charset = UTF8MB4;

create table if not exists step
(
    id   int unique   not null auto_increment,
    code varchar(10)  not null,
    name varchar(100) not null,

    constraint pk_step primary key (id)

) charset = UTF8MB4;

create table if not exists process_step
(
    id         int unique   not null auto_increment,
    step_id    int          not null,
    process_id int          not null,
    status     varchar(100) NULL,
    priority   int default 0,

    constraint pk_process_step primary key (id),

    constraint fk_step_process foreign key (step_id) references step (id),
    constraint fk_process_step foreign key (process_id) references process (id)

) charset = UTF8MB4;

create table if not exists job_category
(
    id          int unique     not null auto_increment,
    code        nvarchar(10)   not null,
    name        nvarchar(100)  not null,
    description nvarchar(1000) null,

    constraint pk_job_category primary key (id)

) charset = UTF8MB4;

create table if not exists job_platform
(
    id          int unique     not null auto_increment,
    code        nvarchar(10)   not null,
    name        nvarchar(100)  not null,
    description nvarchar(1000) null,

    constraint pk_job_platform primary key (id)

) charset = UTF8MB4;

create table if not exists organization
(
    id          int unique     not null auto_increment,
    code        nvarchar(10)   not null,
    name        nvarchar(100)  not null,
    description nvarchar(1000) null,

    constraint pk_organization primary key (id)

) charset = UTF8MB4;

create table if not exists job_position
(
    id          int unique     not null auto_increment,
    code        nvarchar(10)   not null,
    name        nvarchar(100)  not null,
    description nvarchar(1000) null,

    constraint pk_job_position primary key (id)

) charset = UTF8MB4;

create table if not exists job
(
    id              int unique     not null auto_increment,
    code            nvarchar(10)   not null,
    name            nvarchar(255)  not null,
    description     nvarchar(1000) null,
    date_published  datetime,
    job_start_date  datetime,
    no_of_vacancies int            not null,
    job_category_id int            not null,
    job_position_id int            not null,
    job_platform_id int            not null,
    organization_id int            not null,
    process_id      int            not null,


    constraint pk_job primary key (id),

    constraint fk_category_job foreign key (job_category_id) references job_category (id),
    constraint fk_position_job foreign key (job_position_id) references job_position (id),
    constraint fk_platform_job foreign key (job_platform_id) references job_platform (id),
    constraint fk_organization_job foreign key (organization_id) references organization (id),
    constraint fk_process_job foreign key (process_id) references process (id)

) charset = UTF8MB4;

create table if not exists applicant
(
    id         int unique not null auto_increment,
    first_name nvarchar(100),
    last_name  nvarchar(100),
    email      nvarchar(255),
    phone      nvarchar(20),
    summary    nvarchar(1000),

    constraint pk_applicant primary key (id)

) charset = UTF8MB4;


create table if not exists document
(
    id           int unique    not null auto_increment,
    name         nvarchar(100) not null,
    raw_data     longblob,
    url          nvarchar(255),
    last_updated datetime,

    constraint pk_document primary key (id)

) charset = UTF8MB4;


create table if not exists application
(
    id                  int unique     not null auto_increment,
    date_of_application datetime       not null,
    education           nvarchar(1000) not null,
    experience          nvarchar(1000) null,
    other_info          nvarchar(1000) null,
    job_id              int            not null,
    applicant_id        int            not null,

    constraint pk_application primary key (id),

    constraint fk_jobs_application foreign key (job_id) references job (id),
    constraint fk_applicant_application foreign key (applicant_id) references applicant (id)


) charset = UTF8MB4;

create table if not exists applicant_document
(
    id           int unique not null auto_increment,
    document_id  int        not null,
    applicant_id int        not null,

    constraint pk_applicant_document primary key (id),

    constraint fk_document_applicant foreign key (document_id) references document (id),
    constraint fk_applicant_document foreign key (applicant_id) references applicant (id)

) charset = UTF8MB4;

create table if not exists test
(
    id        int unique   not null auto_increment,
    code      nvarchar(10) not null,
    duration  int          null,
    max_score int,

    constraint pk_test primary key (id)

) charset = UTF8MB4;

create table if not exists application_test
(
    id             int unique not null auto_increment,
    test_id        int        not null,
    application_id int        not null,
    start_time     datetime,
    end_time       datetime,

    constraint pk_application_test primary key (id),

    constraint fk_test_application foreign key (test_id) references test (id),
    constraint fk_application_test foreign key (application_id) references applicant (id)

) charset = UTF8MB4;

create table if not exists answers
(
    id                  int unique     not null auto_increment,
    application_test_id int            not null,
    recruiter_id        int            not null,
    total_grades        nvarchar(10)   null,
    pass                bit            null,
    answer_details      nvarchar(1000) null,

    constraint pk_application_test primary key (id),

    constraint fk_application_test_answers foreign key (application_test_id) references application_test (id),
    constraint fk_recruiter_answers foreign key (recruiter_id) references recruiter (id)

) charset = UTF8MB4;

create table if not exists interview
(
    id             int unique not null auto_increment,
    start_time     datetime,
    end_time       datetime,
    application_id int        not null,

    constraint pk_interview primary key (id),

    constraint fk_application_interview foreign key (application_id) references application (id)

);

create table if not exists interview_note
(
    id           int unique    not null auto_increment,
    notes        varchar(2000) null,
    interview_id int           not null,
    recruiter_id int           not null,
    pass         bit           null,

    constraint pk_interview_note primary key (id),

    constraint fk_interview_note foreign key (interview_id) references interview (id),
    constraint fk_recruiter_note foreign key (recruiter_id) references recruiter (id)

) charset = UTF8MB4;





create table if not exists application_evaluation
(
    id             int unique    not null auto_increment,
    notes          varchar(2000) null,
    recruiter_id   int           not null,
    application_id int           not null,
    hired          bit           null,

    constraint pk_application_evaluation primary key (id),

    constraint fk_recruiter_application_evaluation foreign key (recruiter_id) references recruiter (id),
    constraint fk_application_evaluation foreign key (recruiter_id) references recruiter (id)

) charset = UTF8MB4;

create table if not exists application_status
(
    id     int unique    not null auto_increment,
    status varchar(2000) not null,

    constraint pk_application_status primary key (id)

) charset = UTF8MB4;

create table if not exists application_status_change
(
    id                    int unique not null auto_increment,
    date_changed          datetime   not null,
    application_status_id int        not null,
    application_id        int        not null,

    constraint pk_application_status primary key (id),

    constraint fk_application_status_to_change foreign key (application_status_id) references application_status (id),
    constraint fk_application_to_change foreign key (application_id) references application (id)

) charset = UTF8MB4;

