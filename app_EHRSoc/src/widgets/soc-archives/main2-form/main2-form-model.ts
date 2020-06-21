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
        prop: 'socarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'socarchivesname',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'socaccountname',
        prop: 'socaccountname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'socrulename',
        prop: 'socrulename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'state',
        prop: 'state',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'socaccountid',
        prop: 'socaccountid',
        dataType: 'PICKUP',
      },
      {
        name: 'socruleid',
        prop: 'socruleid',
        dataType: 'PICKUP',
      },
      {
        name: 'socarchivesid',
        prop: 'socarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'socarchives',
        prop: 'socarchivesid',
        dataType: 'FONTKEY',
      },
    ]
  }

}