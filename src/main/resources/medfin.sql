create table insurance_estimate (id int unsigned primary key auto_increment, corporate_name varchar(100) not null, patient_name varchar(100) not null, patient_mobile varchar(10) not null);


create table insurance_estimate_doctor_hospital (id int unsigned primary key auto_increment, insurance_estimate_id int unsigned not null, doctor_id int not null, hospital_id int not null, status int not null, foreign key(insurance_estimate_id) references insurance_estimate(id));


create table insurance_estimate_conversation (id int unsigned primary key auto_increment, insurance_estimate_id int unsigned not null, event varchar(100) not null, token varchar(100) not null, foreign key(insurance_estimate_id) references insurance_estimate(id));


create table insurance_estimate_conversation_message (id int unsigned primary key auto_increment, insurance_estimate_conversation_id int unsigned not null, message varchar(100) not null, foreign key(insurance_estimate_conversation_id) references insurance_estimate_conversation(id));


create table insurance_estimate_conversation_document (id int unsigned primary key auto_increment, insurance_estimate_conversation_id int unsigned not null, document_url varchar(100) not null, foreign key(insurance_estimate_conversation_id) references insurance_estimate_conversation(id));
