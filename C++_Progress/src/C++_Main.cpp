//============================================================================
// Name        : C_Pointer.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdio.h>
#include "core/point/Pointer.h"
#include "core/curl/CurlTest.h"
using namespace std;

int main() {
	CurlTest curl;
	curl.getUrl("/home/ruibiao/workspace/git/ProgressDialog/C++_Progress/curl");
	return 0;
}
