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
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'htbh',
        prop: 'htbh',
        dataType: 'TEXT',
      },
      {
        name: 'htlx',
        prop: 'htlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'contracttype',
        prop: 'contracttype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qsrq',
        prop: 'qsrq',
        dataType: 'DATE',
      },
      {
        name: 'jsrq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'htzt',
        prop: 'htzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'contractsignorgid',
        prop: 'contractsignorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormsignorgname',
        prop: 'ormsignorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimlabourcampanyname',
        prop: 'pimlabourcampanyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sydqsj',
        prop: 'sydqsj',
        dataType: 'DATE',
      },
      {
        name: 'jobcontent',
        prop: 'jobcontent',
        dataType: 'TEXT',
      },
      {
        name: 'pimcontractid',
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'demo',
        prop: 'demo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimlabourcampanyid',
        prop: 'pimlabourcampanyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormsignorgid',
        prop: 'ormsignorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimcontract',
        prop: 'pimcontractid',
        dataType: 'FONTKEY',
      },
    ]
  }

}