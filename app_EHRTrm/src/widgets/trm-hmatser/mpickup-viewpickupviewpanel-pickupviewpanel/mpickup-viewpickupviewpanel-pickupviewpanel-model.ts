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
        name: 'trmhmatser',
        prop: 'trmhmatserid',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'trmhmatsername',
      },
      {
        name: 'createman',
      },
      {
        name: 'updateman',
      },
      {
        name: 'lxdh',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'pimpersonname',
      },
      {
        name: 'zjhm',
      },
      {
        name: 'trmtrainagencyname',
      },
      {
        name: 'xb',
      },
      {
        name: 'nj',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'trmtrainagencyid',
      },
      {
        name: 'pimpersonid',
      },
    ]
  }


}