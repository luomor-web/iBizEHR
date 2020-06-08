/**
 * BDWPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class BDWPickupViewpickupviewpanelModel
 */
export default class BDWPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof BDWPickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'orgcode',
      },
      {
        name: 'ormsignorg',
        prop: 'ormsignorgid',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'zzjc',
      },
      {
        name: 'createman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'ormsignorgname',
      },
    ]
  }


}