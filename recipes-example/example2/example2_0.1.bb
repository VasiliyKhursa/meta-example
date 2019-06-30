DESCRIPTION = "TCP server and client that can be run on Raspberry Pi 3 board"
LICENSE = "MIT"
SECTION = "examples"
DEPENDS = ""

SRCREV = "62f4c533077b58525717a5ece2f2c2448f35f6e3"
SRC_URI = "git://github.com/PetroShevchenko/cxemotexnika.git"

LIC_FILES_CHKSUM = "file://LICENSE;md5=7bd7e85475482a3b039c7c955438fbe7"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

S = "${WORKDIR}/git"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/Examples/RaspberryPi3/tcp_server_and_client/tcp_client.c -o tcp_client
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/Examples/RaspberryPi3/tcp_server_and_client/tcp_server.c -o tcp_server
}

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/tcp_client ${D}${bindir}
    install -m 0755 ${S}/tcp_server ${D}${bindir}
}