import org.encog.Encog;
import org.encog.engine.network.actiovation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.MLDataPair;
import org.encog.ml.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class HelloWorld
{
	/**
		 The i n p u t n e c e s s a r y f o r XOR.
	**/
	public static double XOR INPUT[][]={
		{0.0, 0.0}, {1.0, 0.0}, {0.0, 1.0}, {1.0, 1.0};
	}
	
	/**
		The i d e a l d a t a n e c e s s a r y f o r XOR.
	**/
	public static double XOR IDEAL[][] = {
		{0.0},{1.0},{1.0},{0.0}
	}

	/**
		The main method .
		@param a r g s No argumen ts are used .
	**/
	public static void main(finalStringargs[]){
		BasicNetwork network = new BasicNetwork ( ) ;
		network.addLayer( new BasicLayer(null, true, 2));
		network.addLayer( new BasicLayer(new ActivationSigmoid(), true, 3));
		network.addLayer( new BasicLayer(new ActivationSigmoid(), false, 1));
		network.getStructure().finalizeStructure();
		network.reset();
		// c r e a t e t r a i n i n g d a t a
		MLDataSet trainingSet = new BasicMLDataSet (XOR INPUT, XOR IDEAL);

		// t r a i n t h e n e u r al ne twork
		finalResilientPropagationtrain = new ResilientPropagation(network, trainingSet);
		int epoch = 1;
		do
		{
			train.interation();
			System.out.println( "Epoch #" + epoch + "Error : " + train.getError());
			epoch++;
		}
		while (train.getError() > 0.01);
		
		train.finishTraining();

		// t e s t t h e n e u r al ne twork
		System.out.println( "Neural Network R e s ul t s :  ");
		for (MLDataPair pair:trainingSet)
		{
			final MLData output = network.compute(pair.getInput());
			System.out.println(pair.getInput().getData(0) 
								+ "," + pair.getInput().getData(1)
								+ ", actual=" + output.getData(0) + ",ideal=" + pair.getIdeal().getData(0) );
		}

		Encog.getInstance().shutdown();
	}
}
}

