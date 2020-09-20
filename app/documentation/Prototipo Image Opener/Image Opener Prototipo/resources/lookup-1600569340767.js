(function(window, undefined) {
  var dictionary = {
    "58deda7e-c836-4e2e-8df7-939da8b751eb": "Foto 4",
    "c945a758-065d-4e35-886c-87aa01f5176f": "Foto 3",
    "a35c5e76-a95d-4b24-bbe3-f5dddc88538c": "Foto 2",
    "e7497dca-25a8-4cba-afe4-ac0906c8fc2d": "Foto 1",
    "5fd8948e-f8ec-400f-8f47-023a60aa3741": "Seleccionando imagen",
    "1397c941-5fb7-4146-ad90-08aa35ed38d4": "Galeria",
    "7406bdc2-b6e0-4492-bc9d-0b43d594ac4b": "home",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);