import mill._, scalalib._, publish._

object os extends Cross[OsModule]("2.11.12", "2.12.7")
class OsModule(val crossScalaVersion: String) extends CrossScalaModule with PublishModule{
  def publishVersion = "0.1.0"
  def pomSettings = PomSettings(
    description = artifactName(),
    organization = "com.lihaoyi",
    url = "https://github.com/lihaoyi/os",
    licenses = Seq(License.MIT),
    scm = SCM(
      "git://github.com/lihaoyi/os.git",
      "scm:git://github.com/lihaoyi/os.git"
    ),
    developers = Seq(
      Developer("lihaoyi", "Li Haoyi","https://github.com/lihaoyi")
    )
  )

  def ivyDeps = Agg(ivy"com.lihaoyi::geny:0.1.2")

  object test extends Tests {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest::0.6.5")

    def testFrameworks = Seq("utest.runner.Framework")
  }
}