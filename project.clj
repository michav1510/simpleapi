(defproject simpleapi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler simpleapi.core/app
		 :auto-relaod? true
		 :auto-refresh? false}
  :dependencies [[org.clojure/clojure "1.10.1"]
				 [ring/ring "1.2.0"]
				 [ring/ring-jetty-adapter "1.8.0"]
				 [ring/ring-json "0.2.0"]
				 [ring/ring-defaults "0.3.2"] ; to evala meta to cleaning mpas kai parei tis parametrous sosta
                 [mysql/mysql-connector-java "5.1.38"]
				 [org.clojure/java.jdbc "0.7.8"] ; xoris auto den trexei, to dokimasa
                 [org.xerial/sqlite-jdbc "3.23.1"]
				 [org.clojure/data.json "0.2.6"]
				 [compojure "1.6.1"] ; to evala meta to cleaning mpas kai parei tis parametrous sosta
				 [http-kit "2.3.0"] ; to evala meta to cleaning mpas kai parei tis parametrous sosta
				 ]
:jvm-opts ["-Dclojure.spec.skip-macros=true"]

  
  :repl-options {:init-ns simpleapi.core})
