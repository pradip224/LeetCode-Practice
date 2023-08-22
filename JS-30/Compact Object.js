

2705. Compact Object
Medium
75
4
Companies
Given an object or array obj, return a compact object. A compact object is the same as the original object, except with keys containing falsy values removed. This operation applies to the object and any nested objects. Arrays are considered objects where the indices are keys. A value is considered falsy when Boolean(value) returns false.

You may assume the obj is the output of JSON.parse. In other words, it is valid JSON.

 

Example 1:

Input: obj = [null, 0, false, 1]
Output: [1]
Explanation: All falsy values have been removed from the array.
Example 2:

Input: obj = {"a": null, "b": [false, 1]}
Output: {"b": [1]}
Explanation: obj["a"] and obj["b"][0] had falsy values and were removed.
Example 3:

Input: obj = [null, 0, 5, [0], [false, 16]]
Output: [5, [], [16]]
Explanation: obj[0], obj[1], obj[3][0], and obj[4][0] were falsy and removed.
 

Constraints:

obj is a valid JSON object
2 <= JSON.stringify(obj).length <= 106


/**
 * @param {Object} obj
 * @return {Object}
 */

var compactObject = function(obj) {
    // If the input object is null, return null directly.
    if (obj === null) return null;

    // If the input object is an array, filter out falsy values and map compactObject over each element.
    if (Array.isArray(obj)) return obj.filter(Boolean).map(compactObject);

    // If the input object is not an array or null, and it's an object (including nested objects),
    // proceed to compact its keys.
    if (typeof obj !== "object") return obj;

    // Create an empty object to store the compacted key-value pairs.
    const compacted = {};

    // Loop through each key in the input object.
    for (const key in obj) {
        // Recursively compact the value associated with the key.
        let value = compactObject(obj[key]);

        // Check if the compacted value is truthy, and if so, add it to the compacted object.
        if (Boolean(value)) compacted[key] = value;
    }

    // Return the object containing only non-falsy key-value pairs.
    return compacted;
};

