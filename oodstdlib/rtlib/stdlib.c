// ----------------------------------------------------------------------
// File: stdlib.c
// Runtime support library for Oodle
// ----------------------------------------------------------------------

#include <stdlib.h>
#include "stdlib.h"

// ----------------------------------------------------------------------
// I/O Management Functions
// ----------------------------------------------------------------------

// writes <ch> to standard output (<out> is the predefined Oodle Writer object)
void Writer_io_write(void *out, int ch) {
  char c = ch;
  
  write(1, &c, 1);  
}

// reads a character from stdin and returns it (<in> is the predefined Oodle Reader object)
int Reader_io_read(void *in) {
  char c;

  read(0, &c, 1);

  return c;
}

// ----------------------------------------------------------------------
// String Management Functions
// ----------------------------------------------------------------------

// Constructs and returns an Oodle String using chars in <lit>, which must be null terminated
struct String *string_fromlit(void* stringVFT, void* charNodeVFT, char *lit)
{
  struct String *newstr = (struct String *)calloc(sizeof(struct String), 1);
  newstr->vft = stringVFT;
  struct CharNode *cur = NULL;
  while (*lit) {
    struct CharNode *node = (struct CharNode *)calloc(sizeof(struct CharNode), 1);
    node->vft = charNodeVFT;
    node->ch = *lit;
    if (cur == NULL) {
      newstr->list = node;
    } else {
      cur->next = node;
    }
    cur = node;
    lit++;
  }
  return newstr; 
}

unsigned int checkTypeCompatibility(unsigned int* expectedType, unsigned int* foundType) {
  unsigned int ret = 0;
  //expectedType = (unsigned int*)*expectedType;
  while ((unsigned int)expectedType != (unsigned int)foundType && (unsigned int)foundType != 0) {
    foundType = (unsigned int*)foundType[0];
  }
  if ((unsigned int)expectedType == (unsigned int)foundType) {
    ret = 1;
  }
  return ret;
}

void writeint(int num) {
  char buf[20];
  char result[20] = "0";
  char *pos = buf;
  char *writeptr = result;
  int numWritten;
 
  // Handle negative numbers
  if (num < 0) {
    *writeptr++ = '-';
    num = -num;
  }
  
  if (num > 0) {
      
    // Build the number in reverse order
    while (num > 0) {
      *pos++ = (num % 10) + '0';
      num /= 10;
    }
    pos--;
    
    // Now we need to copy the results into the output buffer, reversed
    while (pos > buf) {
      *writeptr++ = *pos--;
    }
    *writeptr++ = *pos;
    *writeptr++ = 0;
  } else {
    // number is 0; use default result
    writeptr = result + 3;
  }
  
  write(1, result, (writeptr - result) - 1);
  
}

void printError(char *message, unsigned int length, int lineNumber) {
  write(1, "On line ", 8);
  writeint(lineNumber);
  write(1, message, length);
}
