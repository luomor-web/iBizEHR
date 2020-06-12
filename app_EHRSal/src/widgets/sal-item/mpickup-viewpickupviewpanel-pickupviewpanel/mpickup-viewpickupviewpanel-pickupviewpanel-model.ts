/**
 * MPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class MPickupViewpickupviewpanelModel
 */
export default class MPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof MPickupViewpickupviewpanelModel
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