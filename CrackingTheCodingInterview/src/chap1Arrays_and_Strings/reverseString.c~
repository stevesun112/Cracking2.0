/* Cracking 1.2:
Implement a function void reverse (char*) in C or C++ which reverses a null-terminated string. */

/* All the methods I can think of mostly needs index, but since this problem gives me only one pointer, I got stuck. */

/* After checking the solution from the book, it's really clever! 
   It uses this given pointer to create a second pointer: the end pointer! to implement this function. */

#include <stdio.h>
#include <string.h>
//using namespace std;	

void reverseString(char* str)
{
printf("%s", str);
	char* end = str;
	char temp;		
	if(str){
		while(*end){
			++end;
			   }

		--end; /* minus one, b/c the last character is the '\' character, we don't need to reverse this. */

	while(str < end){
		temp = *str;
		*str++ = *end;
		*end-- = temp;
			}
		}
//while(str){
//printf("%c ", *str);
//}
}

int main(){
printf("This is a test!");
char* str = "Steve Sun.";
printf("%s", str);
reverseString(str);
return 0;
}
