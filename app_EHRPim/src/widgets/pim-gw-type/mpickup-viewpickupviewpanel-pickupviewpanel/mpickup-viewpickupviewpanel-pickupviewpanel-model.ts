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
        name: 'pimgwtypename',
      },
      {
        name: 'gwlx',
      },
      {
        name: 'ordervalue',
      },
      {
        name: 'createdate',
      },
      {
        name: 'pimgwtype',
        prop: 'pimgwtypeid',
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
    ]
  }


}