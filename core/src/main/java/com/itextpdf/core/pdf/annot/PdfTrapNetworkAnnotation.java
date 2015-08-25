package com.itextpdf.core.pdf.annot;

import com.itextpdf.basics.PdfException;
import com.itextpdf.core.font.PdfFont;
import com.itextpdf.basics.geom.Rectangle;
import com.itextpdf.core.pdf.*;
import com.itextpdf.core.pdf.xobject.PdfFormXObject;

import java.util.List;

public class PdfTrapNetworkAnnotation extends PdfAnnotation {

    public PdfTrapNetworkAnnotation(PdfDocument document, Rectangle rect, PdfFormXObject appearanceStream) {
        super(document, rect);
        if (appearanceStream.getProcessColorModel() == null) {
            throw new PdfException("Process color model must be set in appearance stream for Trap Network annotation!");
        }
        setNormalAppearance(appearanceStream.getPdfObject());
        setFlags(PdfAnnotation.Print | PdfAnnotation.ReadOnly);
    }

    public PdfTrapNetworkAnnotation(PdfDictionary pdfObject, PdfDocument document) {
        super(pdfObject, document);
    }

    public PdfName getSubtype() {
        return PdfName.TrapNet;
    }

    public PdfTrapNetworkAnnotation setLastModified(PdfDate lastModified) {
        return put(PdfName.LastModified, lastModified);
    }

    public PdfString getLastModified() {
        return getPdfObject().getAsString(PdfName.LastModified);
    }

    public PdfTrapNetworkAnnotation setVersion(PdfArray version) {
        return put(PdfName.Version, version);
    }

    public PdfArray getVersion() {
        return getPdfObject().getAsArray(PdfName.Version);
    }

    public PdfTrapNetworkAnnotation setAnnotStates(PdfArray annotStates) {
        return put(PdfName.AnnotStates, annotStates);
    }

    public PdfArray getAnnotStates() {
        return getPdfObject().getAsArray(PdfName.AnnotStates);
    }

    public PdfTrapNetworkAnnotation setFauxedFonts(PdfArray fauxedFonts) {
        return put(PdfName.FontFauxing, fauxedFonts);
    }

    public PdfTrapNetworkAnnotation setFauxedFonts(List<PdfFont> fauxedFonts) {
        PdfArray arr = new PdfArray();
        for (PdfFont f : fauxedFonts)
            arr.add(f.getPdfObject());
        return setFauxedFonts(arr);
    }

    public PdfArray getFauxedFonts() {
        return getPdfObject().getAsArray(PdfName.FontFauxing);
    }
}
