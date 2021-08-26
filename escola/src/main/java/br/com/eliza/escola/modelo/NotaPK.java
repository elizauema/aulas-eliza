package br.com.eliza.escola.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NotaPK implements Serializable {

	private static final long serialVersionUID = -3054578993106195251L;
		private long alunoPK;
		private long seriePK;
		private long materiaPK;

		public NotaPK() {
		}

		public NotaPK(long alunoPK, long seriePK, long materiaPK) {
			super();
			this.alunoPK = alunoPK;
			this.seriePK = seriePK;
			this.materiaPK = materiaPK;
		}

		public long getAlunoPK() {
			return alunoPK;
		}

		public void setAlunoPK(long alunoPK) {
			this.alunoPK = alunoPK;
		}

		public long getSeriePK() {
			return seriePK;
		}

		public void setSeriePK(long seriePK) {
			this.seriePK = seriePK;
		}

		public long getMateriaPK() {
			return materiaPK;
		}

		public void setMateriaPK(long materiaPK) {
			this.materiaPK = materiaPK;
		}
}
