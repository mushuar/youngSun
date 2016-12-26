import o r g . encog . Encog ;
import o r g . encog . e n gi n e . network . a c t i v a t i o n . A c ti v a ti o n Si gm oi d ;
import o r g . encog . ml . data .MLData ;
import o r g . encog . ml . data . MLDataPair ;
import o r g . encog . ml . data . MLDataSet ;
import o r g . encog . ml . data . b a si c . BasicMLDataSet ;
import o r g . encog . n e u r al . ne tworks . BasicNetwork ;
import o r g . encog . n e u r al . ne tworks . l a y e r s . B a sicL a ye r ;
import o r g . encog . n e u r al . ne tworks . t r a i n i n g . p r o p a g a ti o n . r e s i l i e n t .
R e sili e n tP r o p a g a ti o n ;
public c l a s s HelloWorld {
/∗ ∗
∗ The i n p u t n e c e s s a r y f o r XOR.
∗/
public s t a t i c double XOR INPUT [ ] [ ] = { { 0 . 0 , 0. 0 } , { 1 . 0 , 0. 0 } , { 0 . 0 , 1. 0 } , { 1 . 0 , 1. 0 } } ;
/∗ ∗
∗ The i d e a l d a t a n e c e s s a r y f o r XOR.
∗/
public s t a t i c double XOR IDEAL [ ] [ ] = { { 0. 0 } ,{ 1. 0 } , { 1. 0 } , { 0. 0 } } ;
/∗ ∗
∗ The main method .
∗ @param a r g s No argumen ts are used .
∗/
public s t a t i c void main ( f i n a l S t ri n g a r g s [ ] ) {
// c r e a t e a n e u r al ne twork , w i t h o u t u s i n g a f a c t o r y
BasicNetwork network = new BasicNetwork ( ) ;
network . addLayer (
new B a sicL a ye r ( nu l l , true , 2 ) ) ;
network . addLayer (
new B a sicL a ye r (new A c ti v a ti o n Si gm oi d ( ) , true , 3 ) ) ;
network . addLayer (
new B a sicL a ye r (new A c ti v a ti o n Si gm oi d ( ) , f a ls e , 1 ) ) ;
network . g e t S t r u c t u r e ( ) . f i n a l i z e S t r u c t u r e ( ) ;
network . r e s e t ( ) ;
// c r e a t e t r a i n i n g d a t a
MLDataSet t r a i n i n g S e t = new BasicMLDataSet (
XOR INPUT, XOR IDEAL) ;
// t r a i n t h e n e u r al ne twork
f i n a l R e sili e n tP r o p a g a ti o n t r a i n =
new R e sili e n tP r o p a g a ti o n ( network , t r a i n i n g S e t ) ;
int epoch = 1 ;
do {
t r a i n . i t e r a t i o n ( ) ;
System . out . p r i n t l n (
”Epoch #” + epoch + ” E r r o r : ” + t r a i n . g e tE r r o r ( ) ) ;
epoch++;
} while ( t r a i n . g e tE r r o r ( ) > 0 . 0 1 ) ;
t r a i n . f i n i s h T r a i n i n g ( ) ;
// t e s t t h e n e u r al ne twork
System . out . p r i n t l n ( ” Neural Network R e s ul t s : ” ) ;
for (MLDataPair p ai r : t r a i n i n g S e t ) {
f i n a l MLData output = network . compute ( p ai r . g e t I n p u t ( ) ) ;
System . out . p r i n t l n ( p ai r . g e t I n p u t ( ) . getData ( 0 )
+ ” , ” + p ai r . g e t I n p u t ( ) . getData ( 1 )
+ ” , a c t u al=” + output . getData ( 0 ) + ” , i d e a l=”
+ p ai r . g e t I d e a l ( ) . getData ( 0 ) ) ;
}
Encog . g e t I n s t a n c e ( ) . shutdown ( ) ;
}
}

