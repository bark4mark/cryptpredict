package co.mark.howard.cryptpredict.pipeline;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Pipeline<InputOutput> {
	private final Set<Pipe<InputOutput>> pipes = new TreeSet<> ();
	
	public Pipeline<InputOutput> add (final Pipe<InputOutput> pipe) {
		this.pipes.add(pipe);
		return this;
	}

	public InputOutput process(final InputOutput input) {
		InputOutput result = input;
		Iterator<Pipe<InputOutput>> pipesIterator = this.pipes.iterator();
		while(pipesIterator.hasNext()) {
			Pipe<InputOutput> pipe = pipesIterator.next();
			result = pipe.process(result);
		}
		return result;
	}
}
