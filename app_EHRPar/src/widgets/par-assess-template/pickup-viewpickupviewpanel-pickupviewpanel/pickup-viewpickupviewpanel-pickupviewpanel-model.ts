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
        name: 'parassesstemplate',
        prop: 'parassesstemplateid',
      },
      {
        name: 'createman',
      },
      {
        name: 'parassesstemplatename',
      },
      {
        name: 'updateman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'nd',
      },
      {
        name: 'khdx',
      },
      {
        name: 'sfyx',
      },
    ]
  }


}