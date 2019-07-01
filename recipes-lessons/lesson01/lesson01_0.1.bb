
inherit useradd 

DESCRIPTION = "Lesson 01"
SECTION = "base"

#LICENSE = "OPEN"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://lesson01_file01.txt \
           file://lesson01_file02.txt \
"

S = "${WORKDIR}"

PACKAGES =+ "${PN}-user01"

#add two users
USERADD_PACKAGES = "${PN} ${PN}-user01  ${PN}-user02"

GROUPADD_PARAM_${PN} = "-g 1000 group00"
GROUPADD_PARAM_${PN}-user01 = "-g 1001 group01"

USERADD_PARAM_${PN} 	   = "-r -s /bin/false --no-user-group -u 1000 -M user00"
USERADD_PARAM_${PN}-user01 = "-r -s /bin/false --no-user-group -u 1001 -M user01"
USERADD_PARAM_${PN}-user02 = "-r -s /bin/false -u 1002 -M user02"


do_install() {
    install -d -m 755 ${D}${bindir}
    install -m 644 ${B}/lesson01_file01.txt ${D}${bindir}/
    chown user00:group00 ${B}/lesson01_file01.txt
}


