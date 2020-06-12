/**
 * PickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class PickupViewpickupviewpanelModel
 */
export default class PickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'updateman',
      },
      {
        name: 'salsubject',
        prop: 'salsubjectid',
      },
      {
        name: 'enable',
      },
      {
        name: 'salsubjectname',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'subcode',
      },
      {
        name: 'createdate',
      },
    ]
  }


}