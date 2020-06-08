/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        prop: 'pimarchiveschangeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimarchiveschangename',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'dcdw',
        prop: 'dcdw',
        dataType: 'TEXT',
      },
      {
        name: 'drdw',
        prop: 'drdw',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgid2',
        prop: 'ormorgid2',
        dataType: 'PICKUP',
      },
      {
        name: 'daddrq',
        prop: 'daddrq',
        dataType: 'DATE',
      },
      {
        name: 'pimarchivesid',
        prop: 'pimarchivesid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimarchiveschangeid',
        prop: 'pimarchiveschangeid',
        dataType: 'GUID',
      },
      {
        name: 'pimarchiveschange',
        prop: 'pimarchiveschangeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}