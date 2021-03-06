(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
)

(defn less-than [n]
  (fn [x] (< x n))
)

(defn equal-to [n]
  (fn [x] (== x n))
)

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map))
)

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)))
)

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x)))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (empty? string)
    true
    (if (every? whitespace? string)
      true
      false
    )
  )
)

(defn has-award? [book award]
  (contains? (:awards book) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards)
)


(defn my-some [pred a-seq]
  (first
     (filter (fn [x] x) (map pred a-seq))
  )
)


(defn my-every? [pred a-seq]
  (empty?
    (filter (complement pred) a-seq)
  )
)

(defn prime? [n]
  (let [pred (fn [x] x (= (mod n x) 0))]
    (not (some pred (range 2 n)))
  )
)
;^^

