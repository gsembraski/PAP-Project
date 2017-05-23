package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import entity.*;


public class DocumentoNegocio {
	

	public File GerarDocumento(Manual mbp, Pop pop){
		try{
			String caminhoArquivo = "C:\\Projeto\\PAP-Project\\BoasPraticasService\\templates\\manual1.docx";
			String caminhoFinal = "C:\\Projeto\\PAP-Project\\BoasPraticasService\\formatado\\"+mbp.getEmpresa().getCNPJ() + ".docx";
			FileInputStream fisdoc = new FileInputStream(caminhoArquivo);
			XWPFDocument doc = new XWPFDocument(OPCPackage.open(fisdoc));

			// REPLACE ALL HEADERS
			for (XWPFHeader header : doc.getHeaderList()) 
				replaceAllBodyElements(header.getBodyElements(), mbp, pop);
			// REPLACE BODY
			replaceAllBodyElements(doc.getBodyElements(), mbp, pop);
			doc.write(new FileOutputStream(caminhoFinal));
			doc.close();
			
			File arquivoFinal = new File(caminhoFinal);
			
			return arquivoFinal;

		}catch (IOException e) {
			throw new WebApplicationException(e.getMessage(), e);
		}
		catch (InvalidFormatException e) {
			throw new WebApplicationException(e.getMessage(), e);
		}
	}

	private void replaceAllBodyElements(List<IBodyElement> bodyElements, Manual mbp, Pop pop){
		for (IBodyElement bodyElement : bodyElements) {
			if (bodyElement.getElementType().compareTo(BodyElementType.PARAGRAPH) == 0)
				replaceParagraph((XWPFParagraph) bodyElement, mbp, pop);
			if (bodyElement.getElementType().compareTo(BodyElementType.TABLE) == 0)
				replaceTable((XWPFTable) bodyElement, mbp, pop);
		}
	}

	private void replaceTable(XWPFTable table, Manual mbp, Pop pop) {
		for (XWPFTableRow row : table.getRows()) {
			for (XWPFTableCell cell : row.getTableCells()) {
				for (IBodyElement bodyElement : cell.getBodyElements()) {
					if (bodyElement.getElementType().compareTo(BodyElementType.PARAGRAPH) == 0) {
						replaceParagraph((XWPFParagraph) bodyElement, mbp, pop);
					}
					if (bodyElement.getElementType().compareTo(BodyElementType.TABLE) == 0) {
						replaceTable((XWPFTable) bodyElement, mbp, pop);
					}
				}
			}
		}  
	}

	private void replaceParagraph(XWPFParagraph paragraph, Manual mbp, Pop pop) {		
		/*int i = 0;
		List<AnexoModelo> anexos = mbp.getAnexo();*/

		List<Resposta> respostas = mbp.getResposta();
		//InputStream is = new ByteArrayInputStream(mbp.getEmpresa().getLogo());


		for (Resposta respostaM : respostas) {
			for (XWPFRun r : paragraph.getRuns()) {
				String text = r.getText(r.getTextPosition());
				if (text != null && text.contains("{" + respostaM.getNumeroResposta() + "resposta}")) {
					text = text.replace("{" + respostaM.getNumeroResposta() + "resposta}", respostaM.getTexto());
					r.setText(text, 0);
				}
			}
		}


//		if(mbp.getEmpresa().getLogo() != null){
//			try {
//				String caminhoLogo = "logo" + mbp.getEmpresa().getID() + ".jpg";
//				String logo = "{logo}";
//
//
//				File tempLogo = File.createTempFile("logo" + mbp.getEmpresa().getID(), ".jpg");
//				FileOutputStream fos = new FileOutputStream(tempLogo);
//				fos.write(mbp.getEmpresa().getLogo());
//				fos.close();
//				
//				for (XWPFRun r : paragraph.getRuns()) {
//					String text = r.getText(r.getTextPosition());
//					if (text != null && text.contains(logo)) {
//						text = text.replace(logo, "");
//						r.setText(text, 0);
//						try {
//							r.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, caminhoLogo, Units.toEMU(50),Units.toEMU(50));
//						} catch (InvalidFormatException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			} catch (IOException e) {
//				e.getMessage();
//			}
//		}

	}
}