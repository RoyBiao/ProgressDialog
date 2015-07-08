################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/MyIMCXX.cpp \
../src/YiCore.cpp \
../src/YiLog.cpp 

OBJS += \
./src/MyIMCXX.o \
./src/YiCore.o \
./src/YiLog.o 

CPP_DEPS += \
./src/MyIMCXX.d \
./src/YiCore.d \
./src/YiLog.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -I"/home/ruibiao/workspace/android/20150611/MyIMCXX/include/gloox-1.0.10" -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


