Drop Table Roster_Staff;
Drop Table Roster;
Drop Table Staff;
Drop Table Shift;


CREATE TABLE Shift(
    shift_id NUMBER NOT NULL,
    shift_type VARCHAR(5),
    PRIMARY KEY(shift_id)
);

CREATE TABLE  Staff(
	staff_id NUMBER NOT NULL,
	name    VARCHAR2(255) NOT NULL,
        shift_id Number,
	PRIMARY KEY (staff_id),
        Foreign Key (shift_id) references Shift(shift_id)
);

CREATE TABLE  Roster (
	week_num NUMBER,
	staff_needed Number,
        staff_id Number,
        shift_id Number,
	PRIMARY KEY (week_num),
        Foreign Key (staff_id) references Staff(staff_id)
);

Create Table Roster_Staff(
    week_num Number,
    staff_id  Number,
    Primary Key(week_num,staff_id),
    Foreign key(week_num) references Roster(week_num),
    Foreign key(staff_id) references Staff(staff_id)
);


INSERT INTO Shift VALUES(1, 'Day');
INSERT INTO Shift VALUES(2, 'Night');

INSERT INTO Staff VALUES(1,'Wayne Condron',1);
INSERT INTO Staff VALUES(2,'Ruairí Keogh',2);
INSERT INTO Staff VALUES(3,'Ray Ji',1);
INSERT INTO Staff VALUES(4,'Graham Lalor',2);
INSERT INTO Staff VALUES(5,'Lee Healy',1);
INSERT INTO Staff VALUES(6,'Imor Hartnett',2);
INSERT INTO Staff VALUES(7,'Eddy Ekofo',1);
INSERT INTO Staff VALUES(8,'Conor Griffin',2);