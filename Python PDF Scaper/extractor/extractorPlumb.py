from pyexpat.errors import codes
from tokenize import String
from typing import List
import PyPDF2 as p2
from PyPDF2 import pdf
import re
import requests
import pdfplumber
import pandas as pd


# pdf = pdfplumber.open(r"youni\extractor\ug prospectus 2022.pdf", "rb")



# for i in range (0, pdf.getNumPages()):
#   page = PDFfile.pages[i]
#   # page = PDFfile.pages[42]
#   text = page.extract_text()

# # print(text)

#   new_vender_bsc = re.compile(r'^\bBSc\b.*')
#   new_vender_ba = re.compile(r'^\bBA\b.*')
#   new_vender_beng = re.compile(r'^\bBEng\b.*')
#   new_vender_llb = re.compile(r'^\bLLB\b.*')
#   new_vender_msci = re.compile(r'^\bMSci\b.*')
#   new_vender_meng = re.compile(r'^\bMEng\b.*')


#   # print("-----------BSc-----------")
#   for line in text.split('\n'):
#     if(new_vender_bsc.search(line)):
#       print(line)

  # # print("-----------BA-----------")
  # for line in text.split('\n'):
  #   if(new_vender_ba.search(line)):
  #     print(line)

  # # print("-----------BEng-----------")
  # for line in text.split('\n'):
  #   if(new_vender_beng.search(line)):
  #     print(line)

  #     # print("-----------LLB-----------")
  # for line in text.split('\n'):
  #   if(new_vender_llb.search(line)):
  #     print(line)

  # # print("-----------MSci-----------")
  # for line in text.split('\n'):
  #   if(new_vender_msci.search(line)):
  #     print(line)

  # # print("-----------MEng-----------")
  # for line in text.split('\n'):
  #   if(new_vender_meng.search(line)):
  #     print(line)


PDFfile = pdfplumber.open("C:\\Users\\i_lik\\OneDrive\\Projects\\Youni\\youni\\extractor\\ug prospectus 2022.pdf")
# oldPDFfile = open(r"youni\extractor\ug prospectus 2022.pdf", "rb")
# pdf = p2.PdfFileReader(oldPDFfile)


codes = []


def printLines(pageNum):

  PDFfile = pdfplumber.open("C:\\Users\\i_lik\\OneDrive\\Projects\\Youni\\youni\\extractor\\ug prospectus 2022.pdf")
  # oldPDFfile = open(r"youni\extractor\ug prospectus 2022.pdf", "rb")
  # pdf = p2.PdfFileReader(oldPDFfile)


  # for i in range (0, pageNum): #pdf.getNumPages()):
  page = PDFfile.pages[pageNum]
  # page = PDFfile.pages[42]
  text = page.extract_text()

# print(text)

  new_vender_bsc = re.compile(r'^\bBSc\b.*')
  new_vender_ba = re.compile(r'^\bBA\b.*')
  new_vender_beng = re.compile(r'^\bBEng\b.*')
  new_vender_llb = re.compile(r'^\bLLB\b.*')
  new_vender_msci = re.compile(r'^\bMSci\b.*')
  new_vender_meng = re.compile(r'^\bMEng\b.*')


  # print("-----------BSc-----------")
  for line in text.split('\n'):
    if(new_vender_bsc.search(line) or new_vender_ba.search(line) or new_vender_beng.search(line) or new_vender_llb.search(line) or new_vender_msci.search(line) or new_vender_meng.search(line)):
      print(line)

def findCourseCode(pageNum):
  PDFfile = pdfplumber.open("C:\\Users\\i_lik\\OneDrive\\Projects\\Youni\\youni\\extractor\\ug prospectus 2022.pdf")
  # oldPDFfile = open(r"youni\extractor\ug prospectus 2022.pdf", "rb")
  # pdf = p2.PdfFileReader(oldPDFfile)


  # for i in range (0, pageNum): #pdf.getNumPages()):
  page = PDFfile.pages[pageNum]
  # page = PDFfile.pages[42]
  text = page.extract_text()

# print(text)

  new_vender_bsc = re.compile(r'^\bBSc\b.*')
  new_vender_ba = re.compile(r'^\bBA\b.*')
  new_vender_beng = re.compile(r'^\bBEng\b.*')
  new_vender_llb = re.compile(r'^\bLLB\b.*')
  new_vender_msci = re.compile(r'^\bMSci\b.*')
  new_vender_meng = re.compile(r'^\bMEng\b.*')

  # new_vender_code = re.compile(r'^\bC700\b.*')


  # print("-----------BSc-----------")
  for line in text.split('\n'):
    if(new_vender_bsc.search(line) or new_vender_ba.search(line) or new_vender_beng.search(line) or new_vender_llb.search(line) or new_vender_msci.search(line) or new_vender_meng.search(line)):
      # if(line == re.compile(r'[C]\d{3}')):
      test = re.compile(r'[A-Z]+[0-9]+')

      # for match in re.finditer(test, line, re.S):
      #   print match.group(1)
      matches = re.findall(r'[A-Z]+[0-9]+', line, re.S)
      matches2 = re.findall(r'[A-Z]+[0-9]+[A-Z]+[0-9]+', line, re.S)
      if (matches.__len__() == 2):
        temp = matches[0] + matches[1]
        # matches[0].append(matches[1])
        matches = temp
      print(matches.__str__())
      # if(matches.length == 0):

      codes.append(matches)
      # if(matches2.length == 1):
        # codes.append(matches2)

      # if("C700" in line):
      #   print(line)




#cut around the course codes/course years then find way to get extra details
#make umls and wireframes for generating database
#install pycharm

bookList = [42,46,50,54,58,62,67,70,74,78,82,86,89,91,94,98,102,106,110,114,118,122,126]

for num in bookList:
  printLines(num)
  findCourseCode(num)
  
print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
print(codes)





for name in codes:
  database.add(name)










# print("-------------Biology-------------")
# printLines(42)
# findCourseCode(42)
# print("-------------Business-------------")
# printLines(46)
# findCourseCode(46)
# print("-------------Classics-------------")
# printLines(50)
# findCourseCode(50)
# print("-------------Comp Sci-------------")
# printLines(54)
# findCourseCode(54)
# print("-------------Drama-------------")
# printLines(58)
# findCourseCode(58)
# print("-------------Earth Science-------------")
# printLines(62)
# findCourseCode(62)
# print("-------------Economics-------------")
# printLines(67)
# findCourseCode(67)
# print("-------------Electronic Engineering-------------")
# printLines(70)
# findCourseCode(70)
# print("-------------English-------------")
# printLines(74)
# findCourseCode(74)
# print("-------------Geography-------------")
# printLines(78)
# findCourseCode(78)
# print("-------------History-------------")
# printLines(82)
# findCourseCode(82)
# print("-------------Lang, Lit, Culture Modern-------------")
# printLines(86)
# findCourseCode(86)
# print("-------------Lang, Lit, Culture Comp-------------")
# printLines(89)
# findCourseCode(89)
# print("-------------Lang, Lit, Culture Liberal-------------")
# printLines(91)
# findCourseCode(91)
# print("-------------Law, Criminology, Sociology-------------")
# printLines(94)
# findCourseCode(94)
# print("-------------Maths-------------")
# printLines(98)
# findCourseCode(98)
# print("-------------Media-------------")
# printLines(102)
# findCourseCode(102)
# print("-------------Music-------------")
# printLines(106)
# findCourseCode(106)
# print("-------------Philosophy-------------")
# printLines(110)
# findCourseCode(110)
# print("-------------Physics-------------")
# printLines(114)
# findCourseCode(114)
# print("-------------Politics-------------")
# printLines(118)
# findCourseCode(118)
# print("-------------Physics-------------")
# printLines(122)
# findCourseCode(122)
# print("-------------Social Science-------------")
# printLines(126)
# findCourseCode(126)





#Convert to PyCharm

# Make plan for proper dev
# Find way to fix reg
# Add values to db