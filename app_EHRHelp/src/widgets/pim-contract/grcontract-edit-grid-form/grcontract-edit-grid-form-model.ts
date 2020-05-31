/**
 * GRContractEditGrid 部件模型
 *
 * @export
 * @class GRContractEditGridModel
 */
export default class GRContractEditGridModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof GRContractEditGridModel
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
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimcontractid',
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
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