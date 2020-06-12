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
        name: 'salrulename',
      },
      {
        name: 'enable',
      },
      {
        name: 'memo',
      },
      {
        name: 'createdate',
      },
      {
        name: 'salrule',
        prop: 'salruleid',
      },
      {
        name: 'createman',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'salparamname',
      },
      {
        name: 'salparamid',
      },
    ]
  }


}