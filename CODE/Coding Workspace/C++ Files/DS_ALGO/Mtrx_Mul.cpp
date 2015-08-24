#include<stdio.h>
	int main()
	{
		printf("Please enter no of rows in matrix 1 \n");
		int r1=0;
		scanf("%d",&r1);
		printf("Please enter no of columns in matrix 1 \n");
		int c1=0;
		scanf("%d",&c1);
		printf("Please enter no of rows in matrix 2 \n");
		int r2=0;
		scanf("%d",&r2);
		printf("Please enter no of columns in matrix 2 \n");
		int c2=0;
		scanf("%d",&c2);
		if(c1==r2)
		{
			printf("Matrix Multiplication IS Possible \n\n");
			int x[r1][c1];
			int y[r2][c2];
			printf("Please enter the values of the matrix at the position asked\n\n");
			int i,j;
			for(i=0;i<r1;i++)
			{
			for(j=0;j<c1;j++)
			{
			x[i][j]=0;
			printf("Enter value for Matrix 1 at M1 ");
			printf("[");
			printf("%d%d",(i+1),(j+1));
			printf("]");
			printf("\n");
			scanf("\n%d",&(x[i][j]));
			}
			}
			for(i=0;i<r2;i++)
			{
			for(j=0;j<c2;j++)
			{
			y[i][j]=0;
			printf("Enter value for Matrix 2 at M2 ");
			printf("[");
			printf("%d%d",(i+1),(j+1));
			printf("]");
			printf("\n");
			scanf("\n%d",&(y[i][j]));
			}
			}
			int a=0,b=0,c=0,d=0;
			int k;
			int z[r1][c2];
			for(i=0;i<r1;i++)
			{
			for(j=0;j<c2;j++)
			{
			z[i][j]=0;
			}
			}
			int v=(r1*c2);
			for(i=0;i<v;i++)
			{
			for(j=0;j<r1;j++)
			{
			int t=0;
			for(k=0;k<c2;k++)
			{
			int temp1=0,temp2=0,temp3=0;
			temp1=x[j][k];
			temp2=y[k][t];
			temp3=(temp1*temp2);
			t++;
			z[a][b]+=temp3;
			}
			b++;
			if(b==c2)
			{
			a++;
			b=0;
			}
			}
			}
			printf("ANSWER \n\n\n");
			for(i=0;i<r1;i++)
			{
			for(j=0;j<c2;j++)
			{
			printf("%d",z[i][j]);
			printf("  ");
			}
			printf("\n");
			}
		}
		else
		{
			printf("Matrix multiplication IS NOT Possible as no of col. in MA NOT EQUAL TO no of rows in MB");
		}
		return(0);
	}

