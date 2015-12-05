/*
 * Student.h
 *
 *  Created on: 2015-12-5
 *      Author: ruibiao
 */

#ifndef STUDENT_H_
#define STUDENT_H_
#include <iostream>
using namespace std;
class Student {
public:
	Student(int n, int a, int s) :
			num(n), age(a), score(s) {
	}
	virtual ~Student();
	void total();
	static float average(Student &stu);
private:
	int num;
	int age;
	float score;
	static float sum;
	static int count;
};

#endif /* STUDENT_H_ */
