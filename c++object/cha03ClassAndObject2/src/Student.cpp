/*
 * Student.cpp
 *
 *  Created on: 2015-12-5
 *      Author: ruibiao
 */

#include "Student.h"

int Student::count = 0;
float Student::sum = 0;

Student::~Student() {
	// TODO Auto-generated destructor stub
}

void Student::total() {
	sum += score;
	count++;
}

float Student::average(Student &stu) {
	cout << "stu score:" <<stu.score<<endl;
	return sum / count;
}

