#include <stdio.h>
#include <string.h>
#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disalbe:4996)

int main() {
    char word[1000000] = "";
    int cnt = 0;
    
    scanf("%[^\n]s",word);
    if(strlen(word) == 1)
        if(word[0] == ' '){
            printf("%d",0);
            return 0;
        }
            
    for(int i = 0 ; word[i] != '\0' ; i++)
        if(i != 0 && word[i] == ' ')
            if(word[i+1] != ' ' && word[i+1] != '\0')
                cnt++;
            
    
    
    printf("%d",cnt+1);
}
