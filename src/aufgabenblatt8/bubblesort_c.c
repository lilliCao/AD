//
// Beispiel-Bubble-Sort-Implementierung fuer Vergleiche mit Java-Implementierungen
// Tim Tiedemann, HAW Hamburg, 2016
// 
#include <stdio.h>
#include <time.h>
 
//
// Kompilieren ohne OpenMP: 
// gcc -Wall -o test03c test03c.c
// Kompilieren mit OpenMP: 
// gcc -Wall -Ofast -fopenmp -o test03c test03c.c
// 

#define FIELDSIZE 9000
#define RUNS 100

// void fuellen(int f[FIELDSIZE])
// Beschreibt ein Feld mit initialen Werten (umgekehrt sortiert oder zufaellig)
void fuellen(int f[FIELDSIZE])
{
   for (int i=0;i<FIELDSIZE;i++)
     f[i]=FIELDSIZE-i;
}


// void bubblesort(int f[FIELDSIZE])
// Sortiert das uebergebene Feld mittels Bubble-Sort
void bubblesort(int f[FIELDSIZE])
{
   int tmp;
   int changed=1;
   while (changed)
     {
	changed=0;
	for(int i=0;i<FIELDSIZE-1;i++)
	  if(f[i]>f[i+1])
	    {
	       tmp=f[i];
	       f[i]=f[i+1];
	       f[i+1]=tmp;
	       changed=1;
	    }
     }
}

int main(void) 
{
   int feld[FIELDSIZE];
   int runtime =0;
   //time_t start, stop, t1,t2;
   int t1,t2;
   //int sum=0;
   //start = time(NULL);
   #pragma omp parallel for
   for(int j=0; j<RUNS;j++)
     {     	
	fuellen(feld);
	t1=time(NULL);
	bubblesort(feld);	
    t2=time(NULL);
    runtime = runtime + (t2*1000-t1*1000);
     }
   //stop = time(NULL);
   //runtime = (stop-start);
   //printf("Ergebnis: %i, %i, %i, ... %i, %i, %i\n", feld[0], feld[1], feld[2], feld[FIELDSIZE-3], feld[FIELDSIZE-2], feld[FIELDSIZE-1]);
   printf("Verstrichene Zeit in C:  %d s (%f s je Lauf)\n", runtime, (double)runtime/RUNS);

   return 0;      
}
