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
        prop: 'pimexpaccountid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimexpaccountname',
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
        name: 'fylb',
        prop: 'fylb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fyje',
        prop: 'fyje',
        dataType: 'FLOAT',
      },
      {
        name: 'ffrs',
        prop: 'ffrs',
        dataType: 'INT',
      },
      {
        name: 'ffsj',
        prop: 'ffsj',
        dataType: 'DATE',
      },
      {
        name: 'ffybz',
        prop: 'ffybz',
        dataType: 'TEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimexpaccountid',
        prop: 'pimexpaccountid',
        dataType: 'GUID',
      },
      {
        name: 'pimexpaccount',
        prop: 'pimexpaccountid',
        dataType: 'FONTKEY',
      },
    ]
  }

}