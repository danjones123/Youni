import PyPDF2 as p2
from PyPDF2 import pdf
import re

PDFfile = open(r"youni\extractor\ug prospectus 2022.pdf", "rb")
pdf = p2.PdfFileReader(PDFfile)

# print(pdf.getIsEncrypted())

# for i in range (0, pdf.getNumPages()):
#   pageinfo = pdf.getPage(i)
#   print(pageinfo.extractText())

pageinfo = pdf.getPage(42)
formattedpage = pageinfo.extractText()
splitPage = re.sub(r"[\n\t]*", "", formattedpage)
#  = formattedpage.split

pattern = 'BSc'
result = re.findall(pattern, splitPage)
print(result)

# for i in formattedpage:
  
#   if(i == "BSc"):
#     print(i)
    




# print(pdfread.getIsEncrypted())
# print(pdfread.getDocumentInfo())
# print(pdfread.getNumPages())
