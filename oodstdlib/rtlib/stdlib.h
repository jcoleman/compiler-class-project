
// These structs duplicate the layout of the CharNode and String Oodle classes 
// in stdlib.ood, using the runtime organization presented in class. If your
// class organization differs, you will have to adjust these.

struct CharNode {
  void* vft;
  int reserved;
  int ch;
  struct CharNode *next;
};

struct String {
  void * vft;
  int reserved;
  struct CharNode *list;
};

struct String *string_fromlit(void* stringVFT, void* charNodeVFT, char *);

