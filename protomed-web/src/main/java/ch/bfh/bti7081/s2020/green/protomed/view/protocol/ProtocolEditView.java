package ch.bfh.bti7081.s2020.green.protomed.view.protocol;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

public interface ProtocolEditView {
	
	interface ProtocolEditViewListener {
		void updateProtocol(Protocol protocol);
		void deleteProtocol(Protocol protocol);
		void cancel(Protocol protocol);
	}

  	void addListener(ProtocolEditViewListener listener);

	void loadProtocolData(Protocol protocol);

}
