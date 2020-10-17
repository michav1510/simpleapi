(ns simpleapi.core 
	(:use compojure.core
		  ring.middleware.json
		  ring.util.response
		  [ring.middleware.cookies      :only [wrap-cookies]]    
		  [ring.middleware.params         :only [wrap-params]]   
          [ring.middleware.keyword-params :only [wrap-keyword-params]] 
		  )
	(:require [compojure.route :as route]
			  [clojure.java.jdbc :refer :all]
			  [clojure.data.json :as json]
			  [clojure.pprint :as pp])
	(:gen-class))
	
	
	(def db
		{:classname   "org.sqlite.JDBC"
		 :subprotocol "sqlite"
		 :subname     "db/database.db"
		}) 
  
	(defn getparameter [req pname] (get (:params req) pname))
  
	(defn addtrace-item [lat long user]
		{:lat  lat,
		 :long long,
		 :user user})
	
	(defn output
		"execute query and return lazy sequence"
		[]
		(query db ["select * from traffic_users"]))
  

	(defn addtrace-handler [req]
		(insert! db :traffic_users (addtrace-item (Double. (getparameter req :lat)) (Double. (getparameter req :long)) (getparameter req :user)))
		(response {:get  {:status 200, :body "Ok"}}))
  
	
	(defn request-example [req]
		(response
			{:get
				{:status  200
				 :traces  (output)			 
				}
			}
		)
	)
	    
	(defn ping-response [req] 
		(response {:get  {:status 200, :body "Ok"}}))
	
  
	(defroutes my_routes
		(GET "/ping" [] ping-response)
		(GET "/add" []  addtrace-handler)
		(GET "/request" [] request-example)
		(route/resources "/"))


(def app (-> #'my_routes wrap-cookies wrap-keyword-params wrap-params wrap-json-response))