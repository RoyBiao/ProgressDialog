################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Box.cpp \
../src/Compare.cpp \
../src/Student.cpp \
../src/Time.cpp \
../src/cha03ClassAndObject2.cpp 

OBJS += \
./src/Box.o \
./src/Compare.o \
./src/Student.o \
./src/Time.o \
./src/cha03ClassAndObject2.o 

CPP_DEPS += \
./src/Box.d \
./src/Compare.d \
./src/Student.d \
./src/Time.d \
./src/cha03ClassAndObject2.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


