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
        name: 'enable',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'updateman',
      },
      {
        name: 'salitemname',
      },
      {
        name: 'salitem',
        prop: 'salitemid',
      },
      {
        name: 'xh',
      },
      {
        name: 'salsubjectname',
      },
      {
        name: 'salsubjectid',
      },
    ]
  }


}