class SharedResource{
int bag=0;
volatile boolean itContains=false;
synchronized void put(String name, int i){
while(itContains){
System.out.println(name + ": Producer called wait()...SLEEPING");
try{wait();}
catch(InterruptedException e){}
System.out.println(name + " Producer returned from wait()...WOKE UP");}
bag=i;
System.out.println(name + " (Producer) put in bag: "+bag);
itContains=true;
System.out.println(name + " Producer notify() consumer...WAKE UP CONSUMER");
notify();}
synchronized void get(String name){
while(!itContains){
System.out.println(name + ": Consumer called wait()...SLEEPING");
try{wait();}
catch(InterruptedException e){}
System.out.println(name + " Consumer returned from wait()...WOKE UP");}
System.out.println(name + " (Consumer) got from bag: "+bag);
itContains=false;
System.out.println(name + " Consumer notify() producer...WAKE UP PRODUCER");
notify();}
}
class MyThread extends Thread{
SharedResource s;
String name;
MyThread(SharedResource s, String name){
this.s=s;
this.name=name;}
public void run(){
if(name=="Thread-1"){
for(int a=0; a<10; a++){
//System.out.println("Producer iteration: " + a);
s.put(name,a);}}
else if(name=="Thread-2"){
for(int a=0; a<10; a++){
//System.out.println("Consumer iteration: " + a);
s.get(name);}}
}
public static void main(String args[]){
SharedResource res=new SharedResource();
MyThread t1=new MyThread(res,"Thread-1");
MyThread t2=new MyThread(res,"Thread-2");
t1.start();
t2.start();}
}