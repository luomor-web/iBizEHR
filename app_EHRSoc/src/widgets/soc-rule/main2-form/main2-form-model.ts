/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'socruleid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'socrulename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'nyear',
        prop: 'nyear',
        dataType: 'NSCODELIST',
      },
      {
        name: 'socareaname',
        prop: 'socareaname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'socrulename',
        prop: 'socrulename',
        dataType: 'TEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'socareaid',
        prop: 'socareaid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'socruleid',
        prop: 'socruleid',
        dataType: 'GUID',
      },
      {
        name: 'socrule',
        prop: 'socruleid',
        dataType: 'FONTKEY',
      },
    ]
  }

}