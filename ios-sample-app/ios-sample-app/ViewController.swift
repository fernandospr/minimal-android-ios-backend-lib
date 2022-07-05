//
//  ViewController.swift
//  ios-sample-app
//
//  Created by Fernando Luis Sproviero on 05/07/2022.
//

import UIKit
import MAIBLib

class ViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let example = Example()
        label.text = example.hello(who: "Fernando")
    }

}

