/**
 * HTQDDWWPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class HTQDDWWPickupViewpickupviewpanelModel
 */
export default class HTQDDWWPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof HTQDDWWPickupViewpickupviewpanelModel
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